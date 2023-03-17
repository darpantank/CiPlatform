$(".EditDataTimeBased").click(function () {
    $("#MissionNameTimeBasedModal").val($(this).parent().siblings(".missionnameTimeBased").html());
});
$(".EditDataGoalBased").click(function () {
    $("#MissionNameGoalBasedModal").val($(this).parent().siblings(".missionnameGoalBased").html());
});