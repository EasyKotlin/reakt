export function defaults(props) {
  return {
    empty: props.empty || true,
    workNo: '',
  };
}

export function updateState(ctx, data) {
  ctx.setState(data);
}

export async function search(ctx) {
  const {
    setState,
    getState,
    fn: { message, DB },
  } = ctx;

  const { workNo } = getState();

  let state = {};

  try {
    const users = await DB.User.query({ workNo });

    const empty = !users.data.length;

    if (empty) {
      message.info(`${workNo}查无数据！`);
    }

    state = { ...users, empty };
  } catch (e) {
    message.error(`${workNo}请求出错啦！`);
    state = { users: [], empty: false };
  }
  setState(state);
}
