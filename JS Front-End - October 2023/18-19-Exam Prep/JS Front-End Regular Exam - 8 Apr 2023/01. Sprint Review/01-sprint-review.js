function solve(input) {
    const lines = Number(input.shift());
    const assignees = input.slice(0, lines);
    const commands = input.slice(lines);

    const sprintBoard = {};
    for (const line of assignees) {
        const [assignee, taskId, title, status, points] = line.split(":");
        if (!sprintBoard.hasOwnProperty(assignee)) {
            sprintBoard[assignee] = [];
        }

        sprintBoard[assignee].push({taskId, title, status, points: Number(points)})
    }

    const commandParser = {
        'Add New': addNewTask,
        'Change Status': changeStatus,
        'Remove Task': removeTask,
    }

    for (const line of commands) {
        const commandLineParts = line.split(":");
        const command = commandLineParts[0];
        const commandTasks = commandLineParts.slice(1);
        commandParser[command](...commandTasks);
    }

    // console.log(JSON.stringify(sprintBoard))

    const toDoPoints = getTotalPointsForStatus('ToDo');
    const inProgressPoints = getTotalPointsForStatus('In Progress');
    const codeReviewPoints = getTotalPointsForStatus('Code Review');
    const donePoints = getTotalPointsForStatus('Done');
    console.log(`ToDo: ${toDoPoints}pts`);
    console.log(`In Progress: ${inProgressPoints}pts`);
    console.log(`Code Review: ${codeReviewPoints}pts`);
    console.log(`Done Points: ${donePoints}pts`);
    const unfinishedPointsSum = toDoPoints + inProgressPoints + codeReviewPoints;

    if (donePoints >= unfinishedPointsSum) {
        console.log('Sprint was successful!');
    } else {
        console.log('Sprint was unsuccessful...')
    }

    //FUNCTIONS

    function addNewTask(assignee, taskId, title, status, points) {
            if (!sprintBoard.hasOwnProperty(assignee)) {
            console.log(`Assignee ${assignee} does not exist on the board!`);
            return;
            }
            sprintBoard[assignee].push({ taskId, title, status, points: Number(points) })
        
    }

    function changeStatus(assignee, taskId, newStatus) {
        if (!sprintBoard.hasOwnProperty(assignee)) {
            console.log(`Assignee ${assignee} does not exist on the board!`);
            return;
        }
        const task = sprintBoard[assignee].find((t) => t.taskId === taskId)

        if (!task) {
            console.log(`Task with ID ${taskId} does not exist for ${assignee}!`)
            return;
        }
        
            task.status = newStatus;
        
    }

    function removeTask(assignee, index) {
        index = Number(index);
        
        if (!sprintBoard.hasOwnProperty(assignee)) {
            console.log(`Assignee ${assignee} does not exist on the board!`);
            return;
        }

        if (index < 0 || index >= sprintBoard[assignee].length) {
            console.log('Index is out of range!');
            return;
        }
      
        sprintBoard[assignee].splice(index, 1);
        
    }

    function getTotalPointsForStatus(status) {
        let totalPointsSum = 0;

        Object.values(sprintBoard).forEach((assignee) => {
            assignee.forEach((task) => {
            if (task.status === status) {
                totalPointsSum += task.points;
            }
            });
        });

        return totalPointsSum;
    }
}



solve([
    "5",
    "Kiril:BOP-1209:Fix Minor Bug:ToDo:3",
    "Mariya:BOP-1210:Fix Major Bug:In Progress:3",
    "Peter:BOP-1211:POC:Code Review:5",
    "Georgi:BOP-1212:Investigation Task:Done:2",
    "Mariya:BOP-1213:New Account Page:In Progress:13",
    "Add New:Kiril:BOP-1217:Add Info Page:In Progress:5",
    "Change Status:Peter:BOP-1290:ToDo",
    "Remove Task:Mariya:1",
    "Remove Task:Joro:1",
]);
  console.log("--------------------------------------")
  
  solve(  [
      '4',
      'Kiril:BOP-1213:Fix Typo:Done:1',
      'Peter:BOP-1214:New Products Page:In Progress:2',
      'Mariya:BOP-1215:Setup Routing:ToDo:8',
      'Georgi:BOP-1216:Add Business Card:Code Review:3',
      'Add New:Sam:BOP-1237:Testing Home Page:Done:3',
      'Change Status:Georgi:BOP-1216:Done',
      'Change Status:Will:BOP-1212:In Progress',
      'Remove Task:Georgi:3',
      'Change Status:Mariya:BOP-1215:Done',
  ]
  )