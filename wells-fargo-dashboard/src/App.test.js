import { render, screen } from '@testing-library/react';
import App from './App';
// import axios from 'axios';
jest.mock('axios');
test('renders Dash Board Title', () => {
  render(<App />);
  const dashboardTitle = screen.getByText(/Dash Board Login/i);
  expect(dashboardTitle).toBeInTheDocument();
});
