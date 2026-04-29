import {Chart as ChartJS,CategoryScale,LinearScale,BarElement,Title,Tooltip,Legend,} from 'chart.js';
import { Bar } from 'react-chartjs-2';


ChartJS.register(CategoryScale,LinearScale,BarElement,Title,Tooltip,Legend);

export const options = {
  responsive: true,
  plugins: {
    legend: {
      position: 'top',
    },
    title: {
      display: true,
      text: '막대그래프',
    },
  },
};

const labels = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];

export const data = {
  labels,
  datasets: [
    {
      label: '국어',
      data: [67,75,86,89,100,99,91],
      backgroundColor: 'rgba(255, 99, 132, 0.5)',
    },
    {
      label: '영어',
      data: [80,85,90,95,100,95,90],
      backgroundColor: 'rgba(53, 162, 235, 0.5)',
    },
  ],
};

export function BarChart() {
  return <Bar options={options} data={data} />;
}