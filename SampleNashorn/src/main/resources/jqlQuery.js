/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function main() {
    return Events({
       from: '2016-04-13',
       to_date: '2016-04-14'
    }).groupByUser([getDay],function(value, events){
        return (value || 0) + events.length;
    }).filter(function(item){
        return item.value >= 5;
    }).groupBy(['key.1'], mixpanel.reducer.count());
}

function getDay(event){
    return new Date(event.time).toISOString().substr(0, 10);
}