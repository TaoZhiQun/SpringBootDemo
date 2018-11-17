$(function () {
    table = $('#trade_dynamic-table').DataTable({
        columns: [
            {title: "序号"},
            {title: "玩家昵称"},
            {title: "玩家等级"},
            {title: "所在区"},
            {title: "拥有英雄数量"},
            {title: "操作"}

        ],
        "processing": true,
        "serverSide": true,
        "bFilter": false,
        "aaSorting": [1, "0"],
        "aoColumnDefs": [
            {"bSortable": false, "aTargets": [0, 2]},
            {
                "aTargets": [],
                "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {

                }
            }
        ],
        "ajax": tradeQuery(),
        "dom": 'rt<"bottom"iplB>',
        "language": {
            emptyTable: "没有符合条件的记录",
            /* lengthMenu: "显示 _MENU_ 条 记录",*/
            paginate: {
                "first": "首页",
                "last": "末页",
                "next": "下一页",
                "previous": "上一页"
            },
        },
        "columnDefs": [{
            'targets': 0,
            'searchable': false,
            'orderable': false,
            'className': 'dt-body-center',
        },
            {
                "visible": false
            }],
        "colReorder": {
            fixedColumnsLeft: 5
        }
    });
    $("table:eq(0) th").addClass("sorting_disabled");
});

function findPlayerInfo() {
    var table = $('#trade_dynamic-table').DataTable();
    table.draw();
}

function exportPlayerInfo() {
    var param = {};
    param.playerName = $("#playerName").val();
    param.playerRegion = $("#playerRegion").val();
    $.ajax({
        type: "GET",
        datatype: "json",
        contentType: "application/json",
        url: "/exportPlayerInfo?" + $.param(param),
        success: function (result) {
            alert("成功信息" + JSON.stringify(data));
        }, error: function (data) {
            alert("失败信息" + JSON.stringify(data));
        },
        async: true
    });
}

function tradeQuery() {
    return function (request, drawCallback, settings) {
        var param = {};
        param.playerName = $("#playerName").val();
        param.playerRegion = $("#playerRegion").val();
        param.pageNo = 1;
        param.pageSize = 15;

        $.ajax({
            type: "GET",
            datatype: "json",
            contentType: "application/json",
            url: "/searchPlayerInfo?" + $.param(param),
            success: function (result) {
                var con = result.content;
                var tempArray = new Array();
                for (var i = 0; i < con.length; i++) {
                    var data = [(i + 1),
                        con[i].playerName,
                        con[i].playerLevel,
                        con[i].playerRegion,
                        con[i].availableHeros,
                        "<a href='javascript:void(0)' id='" + i + "&1'>删除</a>"];
                    tempArray.push(data);
                }
                var json = {
                    "draw": request.draw,
                    "recordsTotal": con.length,
                    "recordsFiltered": con.length,
                    "data": tempArray,
                    "column": [con.length - 1]
                }
                drawCallback(json);
            }, error: function (data) {
                alert("失败信息" + JSON.stringify(data));
            },
            async: true
        });
    }
}



