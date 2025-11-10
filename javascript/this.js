const person = {
  first: "first",
  hobbies: ["coding", "reading", "traveling"],
  showHobbies: () => {
    this.hobbies.forEach(hobby => {
      const string = `${this.first} likes to ${hobby}`;
      console.log(string);
    });
  }
};

person.showHobbies();