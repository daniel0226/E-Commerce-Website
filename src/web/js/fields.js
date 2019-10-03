function searchNav(type)
{
    var currentLocation = window.location.href;
    var searchField = "";
    if(type == 0)
    {
        searchField = "In Theatres";
    }else if(type == 1)
    {
        searchField = "Coming Soon";
    }else
    {
        console.log("searchNav error: invalid parameter");
    }
    if(currentLocation.includes("index.html"))
    {
        //location.replace("src/web/html/searchView.html");
    }else{
        //location.replace("../html/SearchView.html");
    }   
}

function openTab(event, TabID)
{
    var i, tabBody, tabLinks;
    tabBody = document.getElementsByClassName("tabcontent");
    for(i = 0; i<tabBody.length; i++)
    {
        tabBody[i].style.display = "none";
    }
    tabLinks = document.getElementsByClassName("tablinks");
    for(i = 0; i<tabLinks.length; i++)
    {
        tabLinks[i].className = tabLinks[i].className.replace("tabActive", "");
    }
    document.getElementById(TabID).style.display = "block";
    event.currentTarget.className += " tabActive";
}