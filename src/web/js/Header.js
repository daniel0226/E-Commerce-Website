window.onload = function()
{
    function loadDate()
    {
        var todaysDate = new Date();
        //document.getElementById("datetime").innerHTML = "See it Today, " + todaysDate.toLocaleDateString() + ".";
    }


    loadDate();
}
function showMenuItems()
{
    document.getElementById("movieDropDown").classList.toggle("show");
}
window.onclick=function(event)
{
    if(!event.target.matches('.movieDropDownBtn'))
    {
        var dropDownItems = document.getElementsByClassName("dropDownItems");
        for(var i = 0; i < dropDownItems.length; i++)
        {
            if(dropDownItems[i].classList.contains('show'))
            {
                dropDownItems[i].classList.remove('show');
            }
        }
    }
}