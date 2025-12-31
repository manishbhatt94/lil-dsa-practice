import { getContext, writeContextFiles } from './context-util.js';
import { makeScaffold } from './render-template.js';

main();

async function main() {
  try {
    const context = getContext();
    await makeScaffold(context);
    await writeContextFiles(context);
  } catch (err) {
    console.error("Something went wrong", err.message);
    console.error(err);
  }
}
