import { Button } from "@/components/ui/button";
import { Switch } from "@/components/ui/switch";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";

export default function Home() {
  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-24">
      <p className={"text-body"}>Hi there welcome to markdown editor</p>
      <h3 className={"text-heading-s"}>Hi there welcome to markdown editor</h3>
      <h2 className={"text-heading-m"}>Hi there welcome to markdown editor</h2>
      <h1 className={"text-preview-heading-4xl"}>
        Hi there welcome to markdown editor
      </h1>
      <h2 className={"text-preview-heading-3xl"}>
        Hi there welcome to markdown editor
      </h2>
      <h3 className={"text-preview-heading-2xl"}>
        Hi there welcome to markdown editor
      </h3>
      <h4 className={"text-preview-heading-xl"}>
        Hi there welcome to markdown editor
      </h4>
      <h5 className={"text-preview-heading-lg"}>
        Hi there welcome to markdown editor
      </h5>
      <h6 className={"text-preview-heading-sm"}>
        Hi there welcome to markdown editor
      </h6>
      <p className={"text-preview-body"}>Hi there welcome to markdown editor</p>
      <p className={"text-preview-body font-bold"}>
        Hi there welcome to markdown editor
      </p>
      <p className={"text-markup-body"}>Hi there welcome to markdown editor</p>
      <Button>Save Changes</Button>
      <Button variant={"ghost"} size={"icon"}>
        +
      </Button>
      <Switch />
      <div>
        <Label htmlFor={"documentName"}>Document Name</Label>
        <Input id={"documentName"} type={"text"} />
      </div>
    </main>
  );
}