$(document).ready(metodo);

function metodo()
{
    $("#selectTipo").change(selectChange);
}
function selectChange()
{
    var select = $(this);
    var id = select.val();
    /*var opciones = "";
    switch(id)
    {
        case "-1":
            alert("el objeto seleccionado es incorrecto");
            opciones = "<option value='-1'>Seleccione tipo de mascota</option>";
            break;
        case "0":
            opciones = "<option value='-1'>Seleccione tipo de mascota</option>" +
                        "<option value='0'>Kilterrier</option>" +
                        "<option value='1'>Pastor Aleman</option>" +
                        "<option value='2'>Poodle</option>" +
                        "<option value='3'>Pug</option>";
            break;
        case "1":
             opciones = "<option value='-1'>Seleccione tipo de mascota</option>" +
                        "<option value='0'>Siames</option>" +
                        "<option value='1'>Persa</option>" +
                        "<option value='2'>Angora</option>" +
                        "<option value='3'>Gato Montañes</option>";
            break;
        case "2":
             opciones = "<option value='-1'>Seleccione tipo de mascota</option>" +
                        "<option value='0'>Mustang</option>" +
                        "<option value='1'>Australiano</option>" +
                        "<option value='2'>Ponny</option>" +
                        "<option value='3'>Arabe</option>";
            break;
    }*/
    
    var data = {"id":id};
    $.post("ServletSelect",data,function(valor)
    {
        $("#selectRaza").html(valor);
    });
    //$("#selectRaza").html(opciones);
            
}