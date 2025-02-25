interface InputProps extends React.InputHTMLAttributes<HTMLInputElement> {
    customProp?: string;
}

const Input: React.FC<InputProps> = (propes = {}) => {
  return <input {...propes} className={`w-full p-3 border mt-1 bg-gray-100 border-gray-300 rounded-[8px] focus:outline-none focus:ring-2 focus:ring-blue-300`}/>;
};

export default Input;