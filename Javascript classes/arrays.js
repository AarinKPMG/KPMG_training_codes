let arr = new Array();
let arr2 = [];

let fruits = ["apple","oranges","plum"];

console.log(fruits[0])
console.log(fruits[1])
console.log(fruits[2])

fruits[2] = "pineapple";
fruits[3] = "Papaya";

console.log(fruits.length)

let arr3 = ["apple",{name: "AAR"}, true, function(){console.log("Im called from array");} ];
arr3[3]();

console.log(fruits);
fruits.push("watermelon");
console.log(fruits);
console.log("element removed is "+ fruits.pop());  // removed from end

fruits.unshift("Guava");    // add in beginning
console.log(fruits);

console.log("element removed is "+ fruits.shift());    // remove from beginning
console.log(fruits);

let arr4 = fruits;
arr4.push("avacado");
console.log(fruits)

for(let i=0 ; i<arr4.length ; i++){
    console.log(arr4[i]);
}

for( let fruit of fruits){
    console.log(fruit);
}

fruits.length = 2;

let num = [3,6,8,10,12];
let odd = 3;

num.forEach(function(n){
    if( n==odd ){
        num.shift();
    }
});

console.log(num)