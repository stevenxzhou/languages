// 实现将类似'(1,2,3),(4,5,6),(7,8,9)'的字符串转换成一个data structrue

// let str: string = '(1,2,3),(4,5,6),(7,8,9)';
// let pattern = /\((\d+\,\d+\,\d+)\)/g;
// let compile = new RegExp(pattern);
// console.log(pattern.exec(str)[1]); // 1,2,3
// console.log(pattern.exec(str)[1]); // 4,5,6
// console.log(pattern.exec(str)[1]); // 7,8,9


// 
// let match: RegExpExecArray | null;
// let result: number[][] = [];
// while ((match = pattern.exec(str)) !== null) {
//     let numbers: number[] = match[1].split(",").map(Number);
//     result.push(numbers);
// }

// console.log(result)


// let phoneNumberPattern: RegExp = /\d{3}-\d{3}-\d{4}/;
// console.log(phoneNumberPattern.test("302-765-8515"));


// let gmailPattern: RegExp = /^[a-z0-9._%+-]+@gmail\.com$/i;
// console.log(gmailPattern.test("taybson_123@gmail.com")); // true
// console.log(gmailPattern.test("john.doe@gmail.com")); // true
// console.log(gmailPattern.test("invalid@gmail")); // false


// let phoneNumberPatternCHN = /^\(\d{3,4}\)-\d{7}$/
// let res = phoneNumberPatternCHN.test("(024)-3661065")
// console.log(res);


function extractAndValidateEmails(text) {
    // Write a regex to match email patterns
    const emailRegex = /\b([a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.(?:com|org|net))\b/g;
    const matches = text.match(emailRegex) || [];
    console.log(matches);
    // // Write a regex to validate emails
    // const validEmailRegex = /^[YOUR_REGEX_HERE]$/;

    // return matches.filter(email => validEmailRegex.test(email));
}

// // Example input
const inputText = `
    Here are some emails: valid.email@example.com, invalid-email@.com, user_name@domain.org, invalid@domain.c0m.
    Another valid one: hello.world@sub-domain.net
`;

console.log(extractAndValidateEmails(inputText));


// const regex = /(hello|world)/;
// const str = "hello world";
// const matches = str.match(regex);
// console.log(matches[1]); // ["hello", "hello"]
// console.log(matches]); // ["hello", "hello"]