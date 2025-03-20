import { Tutorial } from "./tutorial.model";

export class Comment {
    id : any ;
    content : string ;
    tutorial : Tutorial ;

    constructor( id : any , content : string ){
        this.id = id ;
        this.content = content ;
    }
}
