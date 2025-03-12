
// ! is known as non-null assertion operator and is used to assert that 
// a value is not null or undefined

function processString(text : string | null | undefined){
    const notNullTest : string = text !; //must be a string
    console.log(notNullTest.toUpperCase());
}

processString("hello");
// processString(null); //error at runtime