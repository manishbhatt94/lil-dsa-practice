export function parseSignature(signature) {
  signature = signature.trim();

  // Step 1: find '('
  const parenIndex = signature.indexOf('(');
  const beforeParen = signature.substring(0, parenIndex).trim();

  // Step 2: split into tokens, last one is method name
  const tokens = beforeParen.split(/\s+/);
  const methodName = tokens[tokens.length - 1];
  const returnType = tokens.slice(0, -1).join(' ');

  // Step 3: extract parameter string
  const paramsStr = signature.substring(parenIndex + 1, signature.lastIndexOf(')')).trim();

  const params = parseParams(paramsStr);
  const argsList = params.map(({ name }) => name).join(', ');

  return { returnType, methodName, params, argsList };
}

export function parseParams(paramsStr) {
  if (!paramsStr) return [];

  const params = [];
  let current = '';
  let depth = 0; // track nesting inside <...>

  for (let char of paramsStr) {
    if (char === '<') {
      depth++;
      current += char;
    } else if (char === '>') {
      depth--;
      current += char;
    } else if (char === ',' && depth === 0) {
      params.push(current.trim());
      current = '';
    } else {
      current += char;
    }
  }
  if (current.trim()) params.push(current.trim());

  return params.map((p) => {
    const parts = p.split(/\s+/);
    const type = parts.slice(0, -1).join(' ');
    const name = parts[parts.length - 1];

    // Detect array dimensions based on trailing [] in type
    let arrayDimension = 0;
    const arrayMatch = type.match(/(\[\])+$/);
    if (arrayMatch) {
      arrayDimension = arrayMatch[0].length / 2; // each [] adds 2 chars
    }

    return { type, name, arrayDimension };
  });
}

function testParseSignature() {
  // Examples
  const signatures = [
    'long countTriplets(int n, int sum, long[] arr)',
    'List< Map< String, Integer>> complexMethod(List<  Map <String, Long >  > data, int count)',
    'java.util.List<String> getTriplets()',
    'String... joinStrings(String delimiter, String... parts)',
    'void demo(int x, int[] arr, int[][] matrix, List<String> list)',
  ];

  for (const sig of signatures) {
    console.log(parseSignature(sig));
  }
}
