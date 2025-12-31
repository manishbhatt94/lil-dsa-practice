import path from 'node:path';

import fs from 'fs-extra';
import Handlebars from 'handlebars';

const templateDir = path.join(import.meta.dirname, 'templates');

export async function makeScaffold(ctx) {
  await preprocess();
  await createDirs(ctx);
  compileTemplates();
  await writeFiles(ctx);
}

async function preprocess() {
  registerTemplateHelpers();
  await readTemplates();
}

function registerTemplateHelpers() {
  Handlebars.registerHelper(
    'callInstanceMethod',
    function callInstanceMethodHelper(method, options) {
      let callStr = method.methodName + '(' + method.argsList + ');';
      if (options.hash.instance) {
        callStr = options.hash.instance + '.' + callStr;
      }
      const doesReturn = method.returnType !== 'void';
      if (options.hash.returnResult) {
        return doesReturn ? 'return ' + callStr : callStr;
      }
      if (options.hash.varForReturn && doesReturn) {
        callStr = method.returnType + ' ' + options.hash.varForReturn + ' = ' + callStr;
      }
      return new Handlebars.SafeString(callStr);
    }
  );

  Handlebars.registerHelper('varArrayNotation', function withArrayNotationHelper(param) {
    return param.name + '[]'.repeat(param.arrayDimension);
  });

  Handlebars.registerHelper('varToString', function varToString(param) {
    if (param.arrayDimension === 1) {
      return 'Arrays.toString(' + param.name + ')';
    } else if (param.arrayDimension > 1) {
      return 'Arrays.deepToString(' + param.name + ')';
    }
    return param.name;
  });
}

const noop = () => {};

const templatesConf = [
  {
    templatePath: path.join(templateDir, 'tpl_approach_class.hbs'),
    templateText: null,
    compiled: noop,
    getOutDir: (ctx) => ctx.mainDir,
    render(ctx) {
      return ctx.concreteApproaches.map(({ approachClassName }) => {
        return getRenderOutput.call(
          this,
          Object.assign({}, ctx, { approachClass: approachClassName }),
          `${approachClassName}.java`
        );
      });
    },
  },
  {
    templatePath: path.join(templateDir, 'tpl_debuggable_interface.hbs'),
    templateText: null,
    compiled: noop,
    getOutDir: (ctx) => ctx.mainDir,
    render(ctx) {
      return getRenderOutput.call(this, ctx, 'Debuggable.java');
    },
  },
  {
    templatePath: path.join(templateDir, 'tpl_main_class.hbs'),
    templateText: null,
    compiled: noop,
    getOutDir: (ctx) => ctx.mainDir,
    render(ctx) {
      return getRenderOutput.call(this, ctx, `${ctx.mainClass}.java`);
    },
  },
  {
    templatePath: path.join(templateDir, 'tpl_readme.hbs'),
    templateText: null,
    compiled: noop,
    getOutDir: (ctx) => ctx.mainDir,
    render(ctx) {
      return getRenderOutput.call(this, ctx, 'README.md');
    },
  },
  {
    templatePath: path.join(templateDir, 'tpl_solution_approach_interface.hbs'),
    templateText: null,
    compiled: noop,
    getOutDir: (ctx) => ctx.mainDir,
    render(ctx) {
      return getRenderOutput.call(this, ctx, 'SolutionApproach.java');
    },
  },
  {
    templatePath: path.join(templateDir, 'tpl_test_class.hbs'),
    templateText: null,
    compiled: noop,
    getOutDir: (ctx) => ctx.testDir,
    render(ctx) {
      return getRenderOutput.call(this, ctx, `${ctx.testClass}.java`);
    },
  },
];

function getRenderOutput(ctx, outFileName) {
  const outPath = path.join(this.getOutDir(ctx), outFileName);
  const rendered = this.compiled(ctx);
  return { outPath, rendered };
}

async function readTemplates() {
  return Promise.all(
    templatesConf.map((config) => {
      return fs.readFile(config.templatePath, 'utf8').then((contents) => {
        config.templateText = contents;
      });
    })
  );
}

function compileTemplates() {
  templatesConf.forEach((conf) => {
    conf.compiled = Handlebars.compile(conf.templateText);
  });
}

async function writeFiles(ctx) {
  const writeTasks = templatesConf
    .flatMap((conf) => conf.render(ctx))
    .map(({ outPath, rendered }) => fs.writeFile(outPath, rendered, 'utf8'));
  return Promise.all(writeTasks).then(() => {
    console.log('Written all rendered files');
  });
}

async function createDirs(ctx) {
  console.log('ctx.mainDir -', ctx.mainDir);
  console.log('ctx.testDir -', ctx.testDir);
  return Promise.all([fs.ensureDir(ctx.mainDir), fs.ensureDir(ctx.testDir)]);
}
