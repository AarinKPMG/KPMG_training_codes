//Objects or JSON
//Objects store keyed collection of data
//property is a key value pair combination

let user = new Object();
let user2 = {};

user = {
    name : "ABC",
    age : 25
};

console.log("name is " + user.name);
console.log("age is " + user.age);

user.isAdmin = true;
console.log(user);

user["likes JS and TS"] = true
//console.log(user);

delete user.name;
console.log(user);

// let key = prompt("What is the name of the user","ABC");
// console.log(key);

// let fruit = prompt("Which fruit do you want to buy ? ");
// console.log(fruit);

// let bag ={
//     [fruit + 'Computer'] : 5
// };

// console.log(bag.apple)

let obj2 = {
    for : 1,
    let : 2,
    return : 3
};

console.log(obj2.for + obj2.let + obj2.return );
let _ = 1;
let $ = 1;
console.log(+ + $);

function makeUser(name , age){
    return{
        name : name ,
        age : age
    };
}

let user3 = makeUser("XYZ",26);
console.log(user3);

console.log("age" in user3);
console.log("name" in user3);

for(let key in user3){
    console.log(key);
    console.log(user3[key]);
}

let codes ={
    "+91": "India",
    "+1":"US",
    "+44":"UK"
}

for( let code in codes ){
    console.log(code);
}

let a = {};
let b = a;

console.log( a==b )
console.log( a===b )

let a1 = {}
let b1 = {}

console.log(a1 == b1);
console.log(a1 === b1);

let user4 = {
    name : "PQR",
    age: 30
}

let clone = {}

for( let key in user4){
    clone[key] = user4[key];
}

clone.name = "MNO";
console.log(user4.name);

const a3 = 9 ;
