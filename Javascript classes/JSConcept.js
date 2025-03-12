const value = 3.0 ;

// value = 4.0 ;
console.log("value is "+value);
console.log("value is ",value);

{   
    var message = 'Global declared var';
    let msg = "im aarin !";
    {
        let msg = "im poorni !";
        console.log("Message : ",msg);
    }
    console.log("Message : ",msg);
}

function sayHi(){
    var message = 'Var Defined variable';
    console.log(message);
}

sayHi()
console.log(message)


