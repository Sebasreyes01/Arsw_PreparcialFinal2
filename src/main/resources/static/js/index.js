var Message = (function () {
    
    const instance = axios.create({
        baseURL: 'http://localhost:8080'
    });
    
    var _getInput = function () {
        var input = document.getElementById("input").value;
        var date = new Date();
        instance.post('/messages', {
            message: input,
            date: date
        })
                .then(function (response) {
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                });
    };
    
    var displayInfo = function () {
        _getInput();
        var div = document.getElementById("info");
        
    };
    
    return {
        displayInfo:displayInfo
    };
    
})();