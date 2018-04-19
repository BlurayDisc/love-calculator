function findOne(personA, personB) {
  return $.ajax({
    url: config.baseUrl + config.projectId,
    type: "GET",
    data: sortAndConvertToParams(personA, personB)
  });
}

function calculate(personA, personB) {
  // showcasing complex calculation algorithm:
  var loveScore = random(1, 100);
  $.ajax({
    url: config.baseUrl + config.projectId,
    type: "POST",
    data: sortAndConvertToParams(personA, personB, loveScore)
  });
  return {
    personA: personA,
    personB: personB,
    loveScore: loveScore
  };
}

// Sort these names in alphebetical order, and returns the params object.
function sortAndConvertToParams(personA, personB, loveScore) {
  personA = personA.toLowerCase();
  personB = personB.toLowerCase();
  var params = {
    personA: personB > personA ? personA : personB,
    personB: personB > personA ? personB : personA
  };
  if (loveScore) {
    params.loveScore = loveScore;
  }
  return params;
}

function random(from, to) {
  return Math.floor(Math.random() * to) + from;
}
