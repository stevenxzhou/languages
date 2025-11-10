var Status;
(function (Status) {
    Status[Status["COMPLETED"] = 0] = "COMPLETED";
    Status[Status["PENDING"] = 1] = "PENDING";
})(Status || (Status = {}));
console.log(Status.COMPLETED);
