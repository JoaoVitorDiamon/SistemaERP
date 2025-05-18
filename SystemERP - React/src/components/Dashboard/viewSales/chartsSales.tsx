import { Area, AreaChart, CartesianGrid, XAxis } from "recharts";
import {
  ChartConfig,
  ChartContainer,
  ChartTooltip,
  ChartTooltipContent,
} from "@/components/ui/chart";
const chartData = [
  { month: "Janeiro", desktop: 186, mobile: 80 },
  { month: "Fevereiro", desktop: 305, mobile: 200 },
  { month: "Marco", desktop: 237, mobile: 120 },
  { month: "Abril", desktop: 73, mobile: 190 },
  { month: "Maio", desktop: 209, mobile: 130 },
  { month: "Junho", desktop: 214, mobile: 140 },
];
const chartConfig = {
  desktop: {
    label: "Desktop",
    color: "hsl(var(--chart-1))",
  },
  mobile: {
    label: "Mobile",
    color: "hsl(var(--chart-2))",
  },
} satisfies ChartConfig;
export function ChartSales() {
  return (
    <ChartContainer style={{
      height: 250,
      width: 750
    }} config={chartConfig}>

      <AreaChart
        accessibilityLayer
        data={chartData}
        margin={{
          left: 12,
          right: 12,
        }}

      >
        <CartesianGrid vertical={false} />
        <XAxis
          dataKey="month"
          tickLine={false}
          axisLine={false}
          tickMargin={8}
          tickFormatter={(value) => value.slice(0, 3)}
        />
        <ChartTooltip cursor={false} content={<ChartTooltipContent />} />
        <defs>
          <linearGradient id="fillDesktop" x1="0" y1="0" x2="0" y2="1">
            <stop
              offset="5%"
              stopColor="#48BB78"
              stopOpacity={1}
            />
            <stop
              offset="95%"
              stopColor="#48BB78"
              stopOpacity={0.5}
            />
          </linearGradient>
          <linearGradient id="fillMobile" x1="0" y1="0" x2="0" y2="1">
            <stop
              offset="5%"
              stopColor="#2D3748"
              stopOpacity={0.8}
            />
            <stop
              offset="95%"
              stopColor="#2D3748"
              stopOpacity={0.1}
            />
          </linearGradient>
        </defs>
        <Area
          dataKey="mobile"
          type="natural"
          fill="#2D3748"
          fillOpacity={0.3}
          stroke="#2D3748"
          stackId="a"
        />
        <Area
          dataKey="desktop"
          type="natural"
          fill="#4FD1C5"
          fillOpacity={0.3}
          stroke="#4FD1C5"
          stackId="a"
        />
      </AreaChart>
    </ChartContainer>
  );
}
