class Circle{
    constructor(radius){
        this.radius = radius;
    }
    computeArea(){
        return Math.PI * this.radius * this.radius ;
    }
    get area(){
        return Math.PI * this.radius * this.radius ;
    }
}

var obj = new Circle(4);
console.log(obj);

console.log("Area is : "+obj.computeArea());
console.log("Area is : "+obj.area);

class Ellipse{
    constructor(w,h){
        this._width = w;
        this._height = h;
    }

    get area(){
        return Math.PI * this._width * this._height ;
    };

    set width(w){
        this._width = w;
    };

    set height(h){
        this._height = h;
    };
}


class Circle2 extends Ellipse{
    constructor(radius){
        super(radius, radius);
    }
    set radius(r) {
        super.w =r ;
        super.h = r;
    }
}

let obj2 = new Circle2(4);
console.log("area is (constructor) ",obj2.area);
obj2.radius = 10;
console.log("area is (get)",obj2.area);