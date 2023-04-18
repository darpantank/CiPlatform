
$(".EditDataGoalBased").click(function () {
    $("#MissionNameGoalBasedModal").val($(this).parent().siblings(".missionnameGoalBased").html());
    $("#MissionNameGoalBasedModal").val($(this).parent().siblings(".missionIdGoalBased").html());
});