function solve(input) {
  let stateCount = Number(input.shift());
  let sprintBoardCollection = {};
  let commandParser = {
    "Add New": addNew,
    "Change Status": changeStatus,
    "Remove Task": removeTask,
  };
  let totalPoints = {
    ToDo: Number(0),
    "In Progress": Number(0),
    "Code Review": Number(0),
    Done: Number(0),
  };

  for (let i = 0; i < stateCount; i++) {
    const [assignee, taskId, title, status, estimatedPoints] = input
      .shift()
      .split(":");
    if (!sprintBoardCollection.hasOwnProperty(assignee)) {
      sprintBoardCollection[assignee] = [];
    }
    sprintBoardCollection[assignee].push({
      taskId,
      title,
      status,
      estimatedPoints,
    });
    totalPoints[status] += Number(estimatedPoints);
  }

  for (const inputLine of input) {
    let commandTokens = inputLine.split(":");
    let command = commandTokens[0];
    commandParser[command](...commandTokens.slice(1));
    }

    const toDoPoints = totalPoints['ToDo'];
    const inProgressPoints = totalPoints['In Progress'];
    const codeReviewPoints = totalPoints['Code Review'];
    const donePoints = totalPoints['Done'];
    console.log(`ToDo: ${toDoPoints}pts`);
    console.log(`In Progress: ${inProgressPoints}pts`);
    console.log(`Code Review: ${codeReviewPoints}pts`);
    console.log(`Done Points: ${donePoints}pts`);
    const unfinishedPointsSum = toDoPoints + inProgressPoints + codeReviewPoints;

    if (donePoints >= unfinishedPointsSum) {
        console.log('Sprint was successful!');
    } else {
        console.log('Sprint was unsuccessful…')
    }

  function addNew(assignee, taskId, title, status, estimatedPoints) {
    if (sprintBoardCollection.hasOwnProperty(assignee)) {
      sprintBoardCollection[assignee].push({
        taskId,
        title,
        status,
        estimatedPoints,
      });
      totalPoints[status] += Number(estimatedPoints);
      // console.log(sprintBoardCollection[assignee])
    } else {
      console.log(`Assignee ${assignee} does not exist on the board!`);
    }
  }

  function changeStatus(assignee, taskId, newStatus) {
    if (
      sprintBoardCollection.hasOwnProperty(assignee) &&
      sprintBoardCollection[assignee].some((task) => task.taskId === taskId)
    ) {
      const task = sprintBoardCollection[assignee].find(
        (t) => t.taskId === taskId
      );
      task.status = newStatus;
      console.log(task.status);
      console.log(newStatus);
    }
  }

  function removeTask(assignee, index) {
    index = Number(index);
    // const isValid = index >= 0 && index < sprintBoardCollection[assignee].length;
    if (sprintBoardCollection.hasOwnProperty(assignee)) {
        sprintBoardCollection[assignee].splice(index, 1);
    } else {
      console.log(`Assignee ${assignee} does not exist on the board!`);
    }
  }
//   if (!isValid) {
//     console.log("Index is out of range!");
//   }

    
    
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

// solve(  [
//     '4',
//     'Kiril:BOP-1213:Fix Typo:Done:1',
//     'Peter:BOP-1214:New Products Page:In Progress:2',
//     'Mariya:BOP-1215:Setup Routing:ToDo:8',
//     'Georgi:BOP-1216:Add Business Card:Code Review:3',
//     'Add New:Sam:BOP-1237:Testing Home Page:Done:3',
//     'Change Status:Georgi:BOP-1216:Done',
//     'Change Status:Will:BOP-1212:In Progress',
//     'Remove Task:Georgi:3',
//     'Change Status:Mariya:BOP-1215:Done',
// ]
// )
