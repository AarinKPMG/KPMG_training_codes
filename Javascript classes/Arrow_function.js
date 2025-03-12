var x = a=>a+1;
console.log("Output is : "+x(4));

function addOne(a){
    return a+1;
}

console.log("Output is "+addOne(4));

var x1 = function(a){        // Function Expression : you can cal it once and 
    return a+1;              // it will assign the output of function to var x1
}

console.log("output is "+ x1(4));

[1,2,3,4].forEach( a => console.log( a+"=>"+a*a ) );
console.log( [11,43,1,4].sort((a,b)=>a-b) );

var x2 = ( a=2 , b=3 ) => a*b ;          // this is called as default function parameter
console.log(x2(1));
console.log(x2(1,6));

var x3 = function( a, b , ...args){      // spread operator or rest function parameter
    console.log("a = "+ a +" , b = " + b + " , "+args.length + "args left"); 
}
x3(2,3,4,6);


var name = "ABC"; 
var message = `Hello ${name}`;          // String templating
console.log("Message is ",message);

