export interface ITheme {
  themeId: number;
  title: string;
  color: string;
}

export class Theme implements ITheme {
  color: string;
  themeId: number;
  title: string;

  constructor(themeId: number, title: string, color: string) {
    this.themeId = themeId;
    this.title = title;
    this.color = color;
  }
}
