
 import Person from './Person.js'
 

 let a = 10;
a=20;
console.log("Hello world with "+a);

function myAdd(b,c){
    console.log("add b+c ="+(b+c));
}

myAdd(12,10);

let mySub = (d,e)  => {
    console.log("Sub d-e="+(d-e));
} 

mySub(34,6);

mySub = (f,g,h) => console.log("f-g-h = "+(f-g-h));


mySub(123,7,89);


 a =new Person();
 a.printName();






 