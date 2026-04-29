import {
  Chart as ChartJS,
  LinearScale,
  PointElement,
  Tooltip,
  Legend,
} from 'chart.js';
import { Bubble } from 'react-chartjs-2';

ChartJS.register(LinearScale, PointElement, Tooltip, Legend);

const randomInt = (min, max) => {
  return Math.floor(Math.random() * (max - min + 1)) + min;
};

export const options = {
  scales: {
    y: {
      beginAtZero: true,
    },
  },
};

export const data = {
  datasets: [
    {
      label: 'Red dataset',
      data: Array.from({ length: 50 }, () => ({
         x: randomInt(-100, 100),
        y: randomInt(-100, 100),
        r: randomInt(5, 20),
      })),
      backgroundColor: 'rgba(255, 99, 132, 0.5)',
    },
    {
      label: 'Blue dataset',
      data: Array.from({ length: 50 }, () => ({
        x: randomInt(-100, 100),
        y: randomInt(-100, 100),
        r: randomInt(5, 20),
      })),
      backgroundColor: 'rgba(53, 162, 235, 0.5)',
    },
  ],
};

export function BubbleChart() {
  return <Bubble options={options} data={data} />;
}