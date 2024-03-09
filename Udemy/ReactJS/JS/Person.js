import Human from './human.js'

class Person extends Human{
     
    constructor(){
        super();
        this.name="Sandeep";
    }
    
    printName ()  {
        this.printGender();
        console.log("Hello class : "+this.name);
        
    }
}

export default Person;