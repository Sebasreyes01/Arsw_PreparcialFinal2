var Message = (function () {
    
    var instance = axios.create({
        baseURL: 'http://localhost:8080'
    });
    
    var _getInput = function () {
        var input = document.getElementById("input").value;
        if(input == "") {
            alert("There's no message")
        } else {
            var date = new Date();
            var stringDate = date.toString();
            instance.post('/messages', {
                message: input,
                date: stringDate
            })
                .then(function (response) {
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                });
        }

    };

    var _createTable = function (m) {
        var messages = m;
        // console.log(messages);
        var div = document.getElementById("info");
        if(document.getElementById("table") !== null) {
            var t = document.getElementById("table");
            div.removeChild(t);
        }
        var table = document.createElement("table");
        table.setAttribute("id", "table");
        var tableBody = document.createElement("tbody");
        var titleRow = document.createElement("tr");
        var titleCell = document.createElement("td");
        var titleCellText = document.createTextNode("Date");
        titleCell.appendChild(titleCellText);
        titleRow.appendChild(titleCell);
        var titleCell1 = document.createElement("td");
        var titleCellText1 = document.createTextNode("Messages");
        titleCell1.appendChild(titleCellText1);
        titleRow.appendChild(titleCell1);
        tableBody.appendChild(titleRow);
        for (var i = 0; i < messages.length; i++) {
            var row = document.createElement("tr");
            var cell1 = document.createElement("td");
            var cellText1 = document.createTextNode(messages[i].date);
            cell1.appendChild(cellText1);
            row.appendChild(cell1);
            var cell2 = document.createElement("td");
            var cellText2 = document.createTextNode(messages[i].message);
            cell2.appendChild(cellText2);
            row.appendChild(cell2);
            tableBody.appendChild(row);
        }
        table.appendChild(tableBody);
        div.appendChild(table);
        table.setAttribute("border", "2");
    };
    
    var displayInfo = function () {
        _getInput();
        instance.get('/messages')
            .then(function (response) {
                _createTable(response.data);
                document.getElementById("input").value = "";
                console.log(response);
            })
            .catch(function (error) {
                // handle error
                console.log(error);
            })
        
    };
    
    return {
        displayInfo:displayInfo
    };
    
})();