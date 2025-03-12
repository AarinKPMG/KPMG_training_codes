let day = '';

switch( new Date().getDay()){
    case 0 :
        day = "sunday";
        break;
    case 1 :
        day = "monday";
        break;
    case 3 :
        day = "friday" ;
        break ;
}

console.log("Day is ",day);
