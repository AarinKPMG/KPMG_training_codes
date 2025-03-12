/*

function ask( question , yes , no ){
    if( confirm(question)) yes()
    else no();
}

function showOk(){
    console.log("user agreed on this");
}

function showCancel(){
    console.log("user cancaelled the execution");
}

ask("Do you agree ?", showOk ,showCancel);

ask(
    "Do you agree ?",
    function(){
        console.log("user agreed via FE");
    },
    function(){
        console.log("user cancelled via FE");
    }

);

ask(
    "Do you agree ?",
    () =>{ console.log("user agreed via FE"); },
    () =>{  console.log("user cancelled via FE"); }
);

*/
//Array function :

const ar = [ {x:1}, {x:2}, {x:3} ];

const res = ar.reduce((acc,obj)=>{
    return acc + obj.x;
},0);
console.log(res);

const res2 = ar.reduce( (acc,{x})=>{
    return acc + x ;
},0);
console.log(res2);

const res3 = ar.map((a) => a.x).reduce((a,b)=> a+b);
console.log(res3);

const sumReducer = function( resultSoFor, currItem ){
    return resultSoFor + currItem;
}

const values = [10,20,30];
const sum = values.reduce(sumReducer,0);
console.log(sum);

const ar3 = [1,2,4];
console.log(ar3.includes(3));

const product = [
    {productId: 12 , name : "Monitor" , price : 100 , sku : "13345"},
    {productId: 13 , name : "CPU" , price : 14000 , sku : "12335"},
    {productId: 16 , name : "Mouse" , price : 300 , sku : "12365"},
    {productId: 19 , name : "Keyboard" , price : 800 , sku : "12349"},
]

const filteredProduct = product.filter((item)=>{
    return item.price >=100 
})

console.log("Filtered Product",filteredProduct);

const filteredProduct2 = product.map((item) => {
    return item.name
})

console.log("Filtered Product 2 ",filteredProduct2);

const filteredProduct3 = product.find((item)=>{
    return item.price === 12   
});

console.log("Filtered Product 3 ",filteredProduct3);

const totalCartValue = product.reduce( (totalPrice, item)=>{
    return totalPrice + item.price 
} , 0 )

console.log("total cart value ", totalCartValue);
