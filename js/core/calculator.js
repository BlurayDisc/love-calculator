function findOne(personA, personB) {
  return $.ajax({
    url: config.baseUrl + "/" + config.tableId + "/search",
    data: sortAndConvertToParams(personA, personB)
  });
}

function calculate(personA, personB) {
  // showcasing the complex calculation algorithm:
  var love = random(1, 100);
  $.ajax({
    url: config.baseUrl + "/" + config.tableId,
    type: "POST",
    data: sortAndConvertToParams(personA, personB, love)
  });
  return [{ love_score: love }];
}

// Sort these names in alphebetical order, and returns
function sortAndConvertToParams(personA, personB, love) {
  var params = {
    person_a: personB > personA ? personA : personB,
    person_b: personB > personA ? personB : personA
  };
  if (love) {
    params.love_score = love;
  }
  return params;
}

function random(from, to) {
  return Math.floor(Math.random() * to) + from;
}
