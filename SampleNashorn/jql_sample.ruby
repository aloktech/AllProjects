require 'rubygems'
require 'mixpanel_client'

client = Mixpanel::Client.new(
  api_key:    '961bbbdb11d619462497b80bb6f3a31f',
  api_secret: 'edda4d902425195e92106ac868cfee99'
)

data = client.request(
  'events/properties',
  event:     'splash features',
  name:      'feature',
  values:    '["uno", "dos"]',
  type:      'unique',
  unit:      'day',
  from_date: '2016-10-26',
  to_date:   '2016-10-31',
  limit:     5
)

puts data.inspect
