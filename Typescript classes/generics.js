//Generics allow you to create reusable components that works with different types
function identity(arg) {
    return arg;
}
var numId = identity(42);
var stringId = identity("helo");
var numArr = { items: [1, 2, 3, 4] };
var stringArr = { items: ["a", "b", "c"] };
numArr.items.push(5);
stringArr.items.push("d");
console.log(numArr);
console.log(stringArr);
