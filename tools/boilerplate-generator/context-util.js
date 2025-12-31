import path from 'node:path';

import Ajv from 'ajv';
import addFormats from 'ajv-formats';
import fs from 'fs-extra';

// "$schema": "https://json-schema.org/draft/2020-12/schema",
import schema from './context/context-schema.json' with { type: 'json' };
import baseContext from './context/context-for-template.json' with { type: 'json' };

import { parseParams, parseSignature } from './parse-util.js';

const ajv = new Ajv({ allErrors: true });
addFormats(ajv);

const MAVEN_SRC_PATH = path.resolve(import.meta.dirname, '..', '..', 'src');

export function getContext() {
  validateContext();
  return buildContext(structuredClone(baseContext));
}

export async function writeContextFiles(ctx) {
  const writeTasks = [
    [baseContext, 'base-context.json'],
    [ctx, 'extended-context.json'],
  ].map(
    ([obj, fileName]) =>
      fs.writeFile(path.join(ctx.mainDir, fileName), JSON.stringify(obj, null, 4), 'utf8')
  );
  return Promise.all(writeTasks).then(() => {
    console.log('Wrote context files to main package.')
  });
}

function validateContext() {
  // Compile validator
  const validate = ajv.compile(schema);
  // Validate
  const valid = validate(baseContext);

  if (valid) {
    console.log('✅ JSON is valid!');
  } else {
    console.log('❌ JSON validation errors:', validate.errors);
    throw new Error('❌ Context JSON validation failed.');
  }
}

function buildContext(context) {
  context.leafPackage = `${context.probCodePrefix}_${context.mainClass}`;
  context.fullPackage = `manish.dsa.${context.subPackage}.${context.leafPackage}`;
  const packageParts = context.fullPackage.split(".");
  context.mainDir = path.join(MAVEN_SRC_PATH, "main", "java", ...packageParts);
  context.testDir = path.join(MAVEN_SRC_PATH, "test", "java", ...packageParts);
  context.templateDir = path.join(MAVEN_SRC_PATH, "main", "resources", "");
  context.testClass = `${context.mainClass}Test`;
  [
    context.solutionApproach.primaryMethod,
    ...context.solutionApproach.otherMethods,
    context.debuggable.primaryMethod,
    ...context.debuggable.otherMethods,
  ].forEach((methodOverview) => {
    const parsedSignature = parseSignature(methodOverview.fullSignature);
    for (const [key, value] of Object.entries(parsedSignature)) {
      methodOverview[key] = value;
    }
  });
  [
    context.testInputClass,
    context.testOutputClass,
  ].forEach((testClass) => {
    testClass.fields = parseParams(testClass.fieldsList);
  });
  context.concreteApproaches.forEach((approach) => {
    approach.approachClassName = context.leafPackage + "_" + approach.fileNameSuffix;
  });

  return context;
}
