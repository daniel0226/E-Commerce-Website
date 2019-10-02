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