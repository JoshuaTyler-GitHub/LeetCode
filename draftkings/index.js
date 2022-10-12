const _ = require('lodash');

interface Customer {
  customerId: number;
  yearlySpend: number;
}
interface Discount {
  discountId: number;
  productId: number;
  dollarValue: number;
}
interface DiscountAssignment {
  discountId: number;
  customerId: number;
}

/// <summary>
/// Determines whether or not a list of assigned discounts are valid
/// </summary>
/// <param name="assignedDiscounts">Array of DiscountAssignment objects that contain a mapping between discountId and customerId</param>
/// <param name="customers">Array of Customer objects containing info about all customers of the super store</param>
/// <param name="discounts">Array of Discount Objects that can be mapped to customers of the super store</param>
/// <returns><c>Boolean</c> Determines whether or not it is a valid assignment of discounts to customers</returns>
/// <remarks>
const validateDiscounts = (
  assignedDiscounts: DiscountAssignment[],
  customers: Customer[],
  discounts: Discount[],
): boolean => {
  // solution goes here
  return false;
};

/* DO NOT EDIT BELOW - IO processing for unit tests only */

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString: string = '';
let currentLine: number = 0;
let currentVariable: string = '';
let inputArray: string[] = [];
process.stdin.on('data', function (inputStdin) {
  inputString += inputStdin;
});

process.stdin.on('end', function () {
  inputArray = inputString.split('\n');
  main();
});

function readLine() {
  return inputArray[currentLine++];
}

function main() {
  const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

  let discountAssignments: DiscountAssignment[] = [];
  let customers: Customer[] = [];
  let discounts: Discount[] = [];
  let inputRow: string = readLine();
  currentVariable = inputRow.trim();
  while (inputRow) {
    var itemList = inputRow
      .split(',')
      .map((str) => str.trim())
      .filter((str) => str.length > 0); // remove empty strings
    if (itemList.length === 1) {
      currentVariable = itemList[0];
    } else {
      switch (currentVariable) {
        case 'discountAssignment':
          discountAssignments.push({
            discountId: parseInt(itemList[0], 10),
            customerId: parseInt(itemList[1], 10),
          });
          break;
        case 'customer':
          customers.push({
            customerId: parseInt(itemList[0], 10),
            yearlySpend: parseFloat(itemList[1]),
          });
          break;
        case 'discount':
          discounts.push({
            discountId: parseInt(itemList[0], 10),
            dollarValue: parseFloat(itemList[1]),
            productId: 0,
          });
          break;
        default:
          break;
      }
    }

    inputRow = readLine();
  }

  const result: boolean = validateDiscounts(
    discountAssignments,
    customers,
    discounts,
  );

  ws.write((result ? 'true' : 'false') + '\n');

  ws.end();
}
