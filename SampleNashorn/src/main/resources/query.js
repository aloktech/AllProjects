/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function main() {
  return Events({
    from_date: '2016-10-26',
    to_date:   '2016-10-27'
  })
  .groupBy(["name"], mixpanel.reducer.count());
}

