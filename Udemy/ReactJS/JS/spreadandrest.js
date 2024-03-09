const oldNumbers = [1,2,3];
const newNumbers = [...oldNumbers,4,5];
const newSeperateNumbers = [oldNumbers,4,5]
console.log(newNumbers," and => ",newSeperateNumbers);

let obj1 = {
    a1:"Sandeep"
}

let obj2 = {
    ...obj1,
    a2:"Halder"
}

console.log(obj1,obj2);

let filter = (...args) => args.filter(num => num > 3);

console.log("Filtered results: ",filter(1,3,5,7));