<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/table/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/table/bootstrap-table/src/bootstrap-table.css">
<link
	href="<%=request.getContextPath()%>/static/ace/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="http://rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/css/bootstrap-editable.css"
	rel="stylesheet">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/css/select2.min.css" />
     <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/js/select2.min.js"></script>
<script src="<%=request.getContextPath()%>/static/table/bootstrap-table/src/extensions/select2-filter/bootstrap-table-select2-filter.js"></script>
<script src="<%=request.getContextPath()%>/static/table/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/table/bootstrap/js/bootstrap.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/table/bootstrap-table/src/bootstrap-table.js"></script>
<script
	src="http://rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/js/bootstrap-editable.js"></script>
<script
	src="<%=request.getContextPath()%>/static/table/bootstrap-table/src/extensions/editable/bootstrap-table-editable.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/editor/css/editormd.css" />
<script src="<%=request.getContextPath()%>/static/layer/layer.js"></script>


<title>新建接口</title>
</head>
<body>
    <div class="container">
        <h1>Sub Table</h1>
        <p>Use <code>onExpandRow</code> event to handle your detail view.</p>
        <button onclick="run();">456789</button>
        <table id="table"
               data-detail-view="true">
            <thead>
            <tr>
                <th data-field="id">ID</th>
                <th data-field="name">Item Name</th>
                <th data-field="price">Item Price</th>
            </tr>
            </thead>
        </table>
    </div>
<script>
    var $table = $('#table');

	
    $(function () {
        buildTable($table, 8, 1);
    });

    function expandTable($detail, cells) {
        buildTable($detail.html('<table></table>').find('table'), cells, 1);
    }

    function buildTable($el, cells, rows) {
        var i, j, row,
                columns = [],
                data = [];

        for (i = 0; i < cells; i++) {
            columns.push({
                field: 'field' + i,
                title: 'Cell' + i,
                sortable: false
            });
        }
        for (i = 0; i < rows; i++) {
            row = {};
            for (j = 0; j < cells; j++) {
                row['field' + j] = 'Row-' + i + '-' + j;
            }
            data.push(row);
        }
        $el.bootstrapTable({
            columns: columns,
            data: data,
            detailView: cells > 1,
            onExpandRow: function (index, row, $detail) {
                expandTable($detail, cells - 1);
            }
        });
       
    }
	function run(){
		alert(JSON.stringify($('table').bootstrapTable('getData')));
	}
</script>


</body>
</html>