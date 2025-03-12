let map = new Map();
map.set(1, "Number");
map.set('1',"String");
map.set(true, 'Boolean');

console.log(map);
console.log(map.get(1));
console.log(map.get('1'));

console.log(map.size);

let visitorCount = { name : 'PQR' };
let visitorCountMap = new Map();
visitorCountMap.set(visitorCount,123);

console.log(visitorCountMap.get(visitorCount));

let recipeMap = new Map([
    ['cucumber',500],['tomatoes',350],['onion',50]
]);

for(let vegi of recipeMap.keys()){
    console.log(vegi);
}


