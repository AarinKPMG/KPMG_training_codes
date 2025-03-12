//Generics allow you to create reusable components that works with different types

function identity<T>(arg : T) : T{
    return arg;
}

let numId = identity<number> (42);
let stringId = identity<string>("helo");

interface GenericArray<T>{
    items : T[];
}

const numArr : GenericArray<number> = {items : [1,2,3,4]};
const stringArr : GenericArray<string> = {items : ["a","b","c"]};

numArr.items.push(5);
stringArr.items.push("d");

console.log(numArr);
console.log(stringArr);
