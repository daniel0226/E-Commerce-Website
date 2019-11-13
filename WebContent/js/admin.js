$(document).ready(function () {
	console.log("Admin js");
	 getTodaysDate();
     loadAnalyticsNums();
     generatePieChart();
});
function getTodaysDate() {
    var date = new Date();
    var todayIndex = date.getDay();
    var d_names = ["Sunday", "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday"];
    var today = d_names[todayIndex];

    var MonthIndex = date.getMonth();
    var m_names = ["January", "February", "March",
        "April", "May", "June", "July", "August", "September",
        "October", "November", "December"];
    var Month = m_names[MonthIndex];

    var day = date.getDate();
    var year = date.getFullYear();

    var dateToDisplay = today + ", " + Month + " " + day + ", " + year;
    var date = document.getElementsByClassName("js-getTodaysDate");
    for(var i = 0; i < date.length; i++)
    {
    	date[i].innerHTML = dateToDisplay;
    }
}
function loadAnalyticsNums() {
    var pTags = document.getElementsByClassName("js-analytic");
    var start = 0;
    var duration = 750;

    for (var i = 0; i < pTags.length; i++) {
        var end = pTags[i].innerHTML;
        animateNum(pTags[i], start, end, duration);
    }
}

function generatePieChart() {
    var movies = document.getElementById("js-stats").getElementsByTagName("p");
    var ctxP = document.getElementById("pieChart").getContext('2d');
    var myPieChart = new Chart(ctxP, {
        type: 'pie',
        data: {
            labels: [movies[0].textContent.split("#")[0],
            movies[1].textContent.split("#")[0],
            movies[2].textContent.split("#")[0],
            movies[3].textContent.split("#")[0],
            movies[4].textContent.split("#")[0]],
            datasets: [{
                data: [movies[0].textContent.split("#")[1],
                movies[1].textContent.split("#")[1],
                movies[2].textContent.split("#")[1],
                movies[3].textContent.split("#")[1],
                movies[4].textContent.split("#")[1]],
                backgroundColor: ["#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360"],
                hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#616774"]
            }]
        },
        options: {
            responsive: true,
            legend: {
                labels: {
                    // This more specific font property overrides the global property
                    fontColor: 'white'
                }
            }
        }
    });
}
