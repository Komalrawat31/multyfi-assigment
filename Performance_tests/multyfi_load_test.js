import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
  vus: 50,            // 50 virtual users
  duration: '30s',    // run for 30 seconds
  thresholds: {
    http_req_duration: ['p(95)<2000'],   // 95% requests under 2s
    http_req_failed: ['rate<0.05'],      // less than 5% errors
  },
};

export default function () {
  const res = http.get('https://multyfi.com/api/multibaggers/historical');

  check(res, {
    'status is 200': (r) => r.status === 200,
    'response time < 2s': (r) => r.timings.duration < 2000,
  });

  sleep(1); // small wait between requests
}
