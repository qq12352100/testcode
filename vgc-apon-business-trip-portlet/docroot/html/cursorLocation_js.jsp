<aui:script>
function getCursorPos(obj)  
{   
    var CaretPos = 0;   
    if (document.selection) {   
        obj.focus (); 
        var Sel = document.selection.createRange ();   
        Sel.moveStart ('character', -obj.value.length);  
        CaretPos = Sel.text.length;   
    }   
    else if (obj.selectionStart || obj.selectionStart == '0')   
        CaretPos = obj.selectionEnd;   
    return (CaretPos);   
}   


function setCursorPos(obj,pos)   
{   
    if(obj.setSelectionRange) { //Firefox/Safari/Chrome/Opera  
        obj.focus(); //  
        obj.setSelectionRange(pos,pos);   
    } else if (obj.createTextRange) { // IE  
        var range = obj.createTextRange();   
        range.collapse(true);   
        range.moveEnd('character', pos);   
        range.moveStart('character', pos);   
        range.select();   
    }   
}   
  
  
function replaceAndSetPos(obj,pattern,text){   
      
    var pos=getCursorPos(obj);
  
    var temp=obj.value; 
  
  
    obj.value=temp.replace(pattern,text);
      
    var max_length = obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : "";  
    if( obj.value.length > max_length){  
          
        var str1 = obj.value.substring( 0,pos-1 );  
        var str2 = obj.value.substring( pos,max_length+1 );  
        obj.value = str1 + str2;  
          
    }  
      
    pos=pos-(temp.length-obj.value.length);
    setCursorPos(obj,pos);
  
} 
</aui:script>