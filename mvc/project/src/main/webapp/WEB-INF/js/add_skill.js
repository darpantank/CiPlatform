$(document).ready(function() {
    $('#btnRight').click(function(e) {
        var selectedOpts = $('#lstBox1 option:selected');
        if (selectedOpts.length == 0) {
            alert("Nothing to move.");
            e.preventDefault();
        }
        $('#lstBox2').append($(selectedOpts).clone());
        $(selectedOpts).remove();
        e.preventDefault();
    });

    $('#btnLeft').click(function(e) {
        var selectedOpts = $('#lstBox2 option:selected');
        if (selectedOpts.length == 0) {
            alert("Nothing to move.");
            e.preventDefault();
        }
        $('#lstBox1').append($(selectedOpts).clone());
        $(selectedOpts).remove();
        e.preventDefault();
    });
    $('#AddSkills').click(function(e) {
        $('#lstBox2').empty();
        var addSkillFromPop=$('#lstBoxMain').children();
        $('#lstBox2').append($(addSkillFromPop).clone());
    });
    $('#SaveSkills').click(function(e){
        var updatedkillSet=$('#lstBox2').children();;
        $('#lstBoxMain').empty();
        $('#lstBoxMain').append($(updatedkillSet).clone());
    });
});