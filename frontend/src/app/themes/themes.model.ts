export interface ITheme {
  themeId: number;
  title: string;
  subTitle: string;
  color: string;
}

export class Theme implements ITheme {
  themeId: number;
  title: string;
  subTitle: string;
  color: string;

  constructor(themeId: number, title: string, subTitle: string, color: string) {
    this.themeId = themeId;
    this.title = title;
    this.color = color;
    this.subTitle = subTitle;
  }
}
