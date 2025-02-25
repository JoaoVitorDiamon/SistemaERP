interface InputProps extends React.InputHTMLAttributes<HTMLInputElement> {
    customProp?: string;
}

const Input: React.FC<InputProps> = ({ ...props }) => {
  return <input {...props} className="w-full p-2 border border-gray-300 rounded-[8px] focus:outline-none focus:ring-2 focus:ring-blue-300"/>;
};

export default Input;
